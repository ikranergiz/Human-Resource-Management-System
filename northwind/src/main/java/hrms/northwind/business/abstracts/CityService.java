package hrms.northwind.business.abstracts;


import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.entities.concretes.City;

public interface CityService {

	Result addCity(City city);
	DataResult<List<City>> getAll();
}
