import React from 'react';
import './style.css'


const Login = () => {
    
    return (
        <div className="user-login">
          <h1 className="user-login__title">Entrar no Sistema</h1>
          <form autoComplete="nope">
            <div className="user-login__form-control">
              <label htmlFor="email">E-mail</label>
              <input id="email" type="text" name="email" autoComplete="off" />
            </div>
            <div className="user-login__form-control">
              <label htmlFor="password">Senha</label>
              <input id="password" type="password" name="password" />
            </div>
            <button >Entrar</button>
          </form>
        </div>
      );
}

export default Login;