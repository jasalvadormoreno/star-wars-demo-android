package es.jasalvador.starwarsdemo.data.api;

import java.util.List;

import es.jasalvador.starwarsdemo.data.api.entities.Data;
import es.jasalvador.starwarsdemo.data.api.entities.Person;
import retrofit2.http.GET;
import retrofit2.http.Query;
import io.reactivex.rxjava3.core.*;

public interface ApiService {

    @GET("people")
    Observable<Data<List<Person>>> getPeople(@Query("page") int page);
}
