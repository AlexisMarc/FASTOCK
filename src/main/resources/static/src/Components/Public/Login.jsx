import React, { Component } from 'react';
import axios from 'axios';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUser, faLock } from '@fortawesome/free-solid-svg-icons';
import swal from 'sweetalert';

import "./css/main.css";
import Cookies from 'universal-cookie';
import { baseUrl} from '../../Utils/Api';

const url = baseUrl + "auth/login";
const cookies = new Cookies();


class Login extends Component {

    state = {
        form: {
            email: '',
            password: ''
        }
    }

    handleChange = async e => {
        await this.setState({
            form: {
                ...this.state.form,
                [e.target.name]: e.target.value
            }
        });
    }

    iniciarSesion = async () => {
        await axios.post(url, this.state.form)
            .then(response => {
                if (response.data.token) {
                    swal("Estamos dentro!", "Programadores", "success");
                    var respuesta = response.data;
                    cookies.set('token', respuesta.token, { path: "/" });
                    axios.defaults.headers.common['Authorization'] = 'Bearer' + response.data.token;
                    window.location.href = "./dashboard";
                } else {
                    alert(response.data.infoMessage);
                }
            })
            .catch(error => {
                console.log(error);
            })

    }

    componentDidMount() {
        if (cookies.get('token')) {
            window.location.href = "./dashboard";
        }
    }


    render() {
        const { form } = this.state;
        return (
            <div className="limiter">
                <div className="container-login100">
                    <div className="wrap-login100">
                        <div className="login100-pic js-tilt" data-tilt>
                            <img src="../static/images/img-01.png" alt="IMG" />
                        </div>

                        <div className="login100-form validate-form">
                            <span className="login100-form-title">
                                Iniciar sesión
                            </span>

                            <div className="wrap-input100 validate-input" data-validate="Valid email is required: ex@abc.xyz">
                                <input className="input100" type="text" name="email" placeholder="userName" onChange={this.handleChange} />
                                <span className="focus-input100"></span>
                                <span className="symbol-input100">
                                    <i className="fa fa-envelope" aria-hidden="true"><FontAwesomeIcon icon={faUser} /></i>
                                </span>
                            </div>

                            <div className="wrap-input100 validate-input" data-validate="Password is required">
                                <input className="input100" type="password" name="password" placeholder="Constraseña" onChange={this.handleChange} />
                                <span className="focus-input100"></span>
                                <span className="symbol-input100">
                                    <i className="fa fa-lock" aria-hidden="true" ><FontAwesomeIcon icon={faLock} /></i>
                                </span>
                            </div>

                            <div className="container-login100-form-btn">
                                <button className="login100-form-btn" onClick={() => this.iniciarSesion()}>
                                    Ingresar
                                </button>
                            </div>

                            <div className="text-center p-t-12">
                                <span className="txt1">
                                    Olvidó <br />
                                </span>
                                <a className="txt2" href="#">
                                    Usuario / Contraseña?
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Login;