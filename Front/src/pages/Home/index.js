import React, { useEffect, useState } from 'react';
import axios from '../../services/axios';
import './styles.css';




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
            <div className="title">
            <div style={{ marginLeft: 200 }}>LOGIN</div>
            <div style={{ marginLeft: 400 }}>PASSWORD</div>
            <div style={{ marginLeft: 350 }}>NAME</div>
            <div style={{ marginLeft: 450 }}>VERSION</div>
            </div>
            {user_skills.map((user_skill, key) => (
                <div className="user" user_skill={user_skill.id}
                    key={key}>

                    <div>
                        {user_skill.user.login}
                    </div>
                    <div>
                        {user_skill.user.password}
                    </div>
                    <div>
                        {user_skill.skill.name}
                    </div>
                    <div>
                        {user_skill.skill.version}
                    </div>


                </div>

            ))}
        </div>

    )
}

export default Home;