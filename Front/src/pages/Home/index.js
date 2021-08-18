import React, { useEffect, useState } from 'react';
import axios from '../../services/axios';
import './styles.css';
import { Card } from 'primereact/card';



const Home = () => {

    const [user_skills, setUser_skills] = useState([]);


    useEffect(() => {
        axios
            .get("/user_skill")
            .then((response) => {
                setUser_skills(response.data)
                console.log(response.data)
            })
            .catch((err) => {
                console.error("ops! ocorreu um erro" + err);
            });
    }, []);


    return (
        <div className="container">

            {user_skills.map((user_skill, key) => (
                <div className="user" user_skill={user_skill.id}
                    key={key}>
                    <Card title={user_skill.id} subTitle={user_skill.user.login}>
                        <ul class="list-group">
                            <li class="list-group-item"><strong>LOGIN:</strong>
                                {user_skill.user.login}</li>
                            <li class="list-group-item"><strong>PASSWORD:</strong>{user_skill.user.password}</li>
                            <li class="list-group-item"><strong>SKILL:</strong>{user_skill.skill.name}</li>
                            <li class="list-group-item"><strong>NIVEL DE CONHECIMENTO:</strong>{user_skill.knowledge_level}</li>
                            <li class="list-group-item"><strong>VERSÃO:</strong>{user_skill.skill.version}</li>
                        </ul>
                

                    </Card>
                </div>

            ))}
        </div>

    )
}

export default Home;
