package hrms.northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T data, boolean success, String message) {
		super(data, true, message);
	}

	public SuccessDataResult(T data, boolean success) {
		super(data, true);
	}
}
