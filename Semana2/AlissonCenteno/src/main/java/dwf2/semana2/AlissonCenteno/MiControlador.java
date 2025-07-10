package dwf2.semana2.AlissonCenteno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/datos")
public class MiControlador {

    @Autowired
    private MiServicio miServicio;

    @GetMapping
    public List<String> obtenerDatos() {
        return miServicio.obtenerDatos();
    }

    @PostMapping
    public String agregarDato(@RequestBody String nuevoDato) {
        miServicio.agregarDato(nuevoDato);
        return "Dato agregado correctamente: " + nuevoDato;
    }

    @PutMapping("/{index}")
    public ResponseEntity<String> actualizarDato(@PathVariable int index, @RequestBody String nuevoValor) {
        if (miServicio.actualizarDato(index, nuevoValor)) {
            return new ResponseEntity<>("Dato actualizado correctamente en el índice " + index, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Índice " + index + " no válido para actualizar.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> eliminarDato(@PathVariable int index) {
        if (miServicio.eliminarDato(index)) {
            return new ResponseEntity<>("Dato eliminado correctamente del índice " + index, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Índice " + index + " no válido para eliminar.", HttpStatus.NOT_FOUND);
        }
    }
}
