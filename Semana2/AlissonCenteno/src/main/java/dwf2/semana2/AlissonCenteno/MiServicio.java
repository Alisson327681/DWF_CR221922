package dwf2.semana2.AlissonCenteno;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MiServicio {
    private final List<String> datos = new ArrayList<>();

    public List<String> obtenerDatos() {
        return datos;
    }

    public void agregarDato(String nuevoDato) {
        datos.add(nuevoDato);
    }

    public boolean actualizarDato(int index, String nuevoValor) {
        if (index >= 0 && index < datos.size()) {
            datos.set(index, nuevoValor);
            return true;
        }
        return false;
    }

    public boolean eliminarDato(int index) {
        if (index >= 0 && index < datos.size()) {
            datos.remove(index);
            return true;
        }
        return false;
    }
}
