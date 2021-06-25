package es.jasalvador.starwarsdemo.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import es.jasalvador.starwarsdemo.R;
import es.jasalvador.starwarsdemo.utils.AsyncObservableTransformer;
import es.jasalvador.starwarsdemo.data.api.ApiService;
import es.jasalvador.starwarsdemo.data.api.entities.Person;

@AndroidEntryPoint
public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    private TextView textView;

    @Inject
    ApiService apiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.message);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
//        mViewModel.result.observe(getViewLifecycleOwner(), s -> textView.setText(s));


        apiService.getPeople(1)
                .compose(new AsyncObservableTransformer<>())
                .subscribe(data -> {
                    for (Person person : data.getResults()) {
                        Log.d("TAG", person.getName());
                    }
                }, throwable -> Log.e("TAG", "", throwable));
    }
}