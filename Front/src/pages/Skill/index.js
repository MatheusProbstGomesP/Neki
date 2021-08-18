import React, { useEffect, useState } from 'react';
import axios from '../../services/axios';
import './styles.css';
import { Card } from 'primereact/card';



const Skill = () => {

    const [skills, setSkills] = useState([]);


    useEffect(() => {
        axios
            .get("/skill")
            .then((response) => {
                setSkills(response.data)
                console.log(response.data)
            })
            .catch((err) => {
                console.error("ops! ocorreu um erro" + err);
            });
    }, []);


    return (
        <div className="container">

            {skills.map((skill, key) => (
                <div className="user" skill={skill.id}
                    key={key}>
                    <Card title={skill.id} subTitle={skill.name}>

                        <ul className="list-group">
                            <li className="list-group-item"><strong>VERSÃO:</strong>
                                {skill.version}</li>
                            <li className="list-group-item"><strong>DESCRIÇÃO:</strong>{skill.description}</li>

                        </ul>

                    </Card>
                </div>

            ))}
        </div>

    )
}

export default Skill;