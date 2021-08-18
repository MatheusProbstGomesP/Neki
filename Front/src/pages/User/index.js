import React, { useEffect, useState } from 'react';
import axios from '../../services/axios';
import './styles.css';

import { Card } from 'primereact/card';



const User = () => {

    const [users, setUsers] = useState([]);


    useEffect(() => {
        axios
            .get("/user")
            .then((response) => {
                setUsers(response.data)
                console.log(response.data)
            })
            .catch((err) => {
                console.error("ops! ocorreu um erro" + err);
            });
    }, []);


    return (
        <div className="container">


            {users.map((user, key) => (
                <div className="user" user={user.id}
                    key={key}>
                    <Card title={user.id} subTitle={user.login}>

                        <ul className="list-group">
                            <li className="list-group-item"><strong>LOGIN:</strong>
                                {user.login}</li>
                            <li className="list-group-item"><strong>SENHA:</strong>{user.password}</li>

                        </ul>

                    </Card>
                </div>

            ))}
        </div>

    )
}

export default User;