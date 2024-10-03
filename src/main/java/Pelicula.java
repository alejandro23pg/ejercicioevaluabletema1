import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula implements Serializable {
    private String id;
    private String titulo;
    private Integer año;
    private String director;
    private String genero;
}
