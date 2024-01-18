package nelsonssoares.ecomproductsapi.exceptions;
import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class FieldError {
	
	private String field;
	private String message;
}
