export default class Validacion {

    valid = (name, value) => {
        let texto = /^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$/;
        let email = /^(\w+[/./-]?){1,}@[a-z]+[/.]+(\w+[/./-]?){1,}$/;
        let sizeTexto = /^.{2,30}$/;
        let sizeTextoLargo = /^.{2,60}$/;
        let sizeTelefono = /^.{6,10}$/;

        if (name === "nombre" || name === "contacto" || name === "material") {
            if (!texto.test(value)) {
                return true;
            }
            else if (!sizeTexto.test(value)) {
                return true;
            } else {
                return false;
            }
        }
        if (name === "email") {
            if (!email.test(value)) {
                return true;
            } else {
                return false;
            }
        }
        if (name === "direccion") {
            if (!sizeTextoLargo.test(value)) {
                return true;
            } else {
                return false;
            }
        }
        if (name === "telefono") {
            if (!sizeTelefono.test(value)) {
                return true;
            } else {
                return false;
            }
        }
        if (name === "categoria" || name === "tipo") {
            return this.validArray(value);
        }
        if (name === "proveedor"){
            if (value === '') {
                return true;
            } else{
                return false;
            }
        }
    }
    mensaje = (name, value) => {
        let texto = /^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$/;
        let email = /^(\w+[/./-]?){1,}@[a-z]+[/.]+(\w+[/./-]?){1,}$/;
        let sizeTexto = /^.{2,30}$/;
        let sizeTextoLargo = /^.{2,60}$/;
        let sizeTelefono = /^.{6,10}$/;

        if (name === "nombre" || name === "contacto" || name === "material") {
            if (value === '') {
                return "Complete el campo";
            }
            if (!texto.test(value)) {
                return "Digite solo letras";
            }
            else if (!sizeTexto.test(value)) {
                return "La longitud debe estar entre 2 a 30 caracteres";
            } else {
                return false;
            }
        }
        if (name === "email") {
            if (value === '') {
                return "Complete el campo";
            }
            if (!email.test(value)) {
                return "Email invalido";
            } else {
                return false;
            }
        }
        if (name === "direccion") {
            if (value === '') {
                return "Complete el campo";
            }
            if (!sizeTextoLargo.test(value)) {
                return "La longitud debe estar entre 2 a 60 caracteres";
            } else {
                return false;
            }
        }
        if (name === "telefono") {
            if (value === '') {
                return "Complete el campo";
            }
            if (!sizeTelefono.test(value)) {
                return "La longitud debe estar entre 6 a 10 numeros";
            } else {
                return false;
            }
        }
        if (name === "categoria" || name === "tipo") {
            if (this.validArray(value)) {
                return "Complete el campo";
            }
        }
        if (name === "proveedor"){
            if (value === '') {
                return "Complete el campo";
            } else{
                return false;
            }
        }
    }

    validArray = (e) => {
        if (e.length > 0) {
            return false;
        } else {
            return true;
        }
    }

    ValidButton = (datos) => {
        console.log(datos)
        let numero = 0;
        Object.entries(datos).forEach(([key, value]) => {
            if (value === false) {
                numero++;
            } else {
                numero--;
            }

        });
        if (Object.values(datos).length === numero) {
            return false;
        }
        return true;
    }

}