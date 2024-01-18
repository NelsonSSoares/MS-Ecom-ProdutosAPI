package nelsonssoares.ecomproductsapi.exceptions;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private Instant timestamp;
	private Integer status;
	private String error;
	private String path;
	private List<FieldError> fields;
	
	
}