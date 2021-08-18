import React, { useState } from "react";
import { Button, Form } from "react-bootstrap";
import axios from "../../services/axios";
import FormContainer from "../../components/FormContainer";


const Cadastro = () => {
  const [knowledge_level,setKnowledge_level] = useState("");
  const [created_at,setCreated_at] = useState("")
  const [userId,setUserId] = useState("")
  const [skillId,setSkillId] = useState("")



	const submit = (e) => {
		let data = {

      knowledge_level:knowledge_level,
      userId:userId,
      created_at:created_at,
      skillId:skillId,
  


		};
		postUserSkill(data);
	};

	const postUserSkill = (data) => {
		axios.post("/user_skill", data)
			.then((d) => {
				alert("Usuario registrado com sucesso!");
				console.log(d);
			})
			.catch((error) => alert("ocorreu algum erro"));
	};

	return (
		<>
			<FormContainer>
				<Form
					onSubmit={(e) => {
						e.preventDefault();
						submit(e);
					}}
				>
					<Form.Group controlId="knowledge_level">
						<Form.Label>Nivel de conhecimento</Form.Label>
						<Form.Control
							type="text"
							placeholder="Nivel "
							onChange={(e) => setKnowledge_level(e.target.value)}
						></Form.Control>
					</Form.Group>

					<Form.Group controlId="created_at">
						<Form.Label>Data</Form.Label>
						<Form.Control
							type="text"
							placeholder="Data"
							onChange={(e) => setCreated_at(e.target.value)}
						></Form.Control>
					</Form.Group>

					<Form.Group controlId="userId">
						<Form.Label>Id do Usuario</Form.Label>
						<Form.Control
							type="text"
							placeholder="Id do usuario"
							onChange={(e) => setUserId(e.target.value)}
						></Form.Control>
					</Form.Group>

					<Form.Group controlId="skillId">
						<Form.Label>Id da skill</Form.Label>
						<Form.Control
							type="text"
							placeholder="Id da skill"
							onChange={(e) => setSkillId(e.target.value)}
						></Form.Control>
					</Form.Group>


				
					<Button type="submit" variant="primary">
						Registrar Usuario
					</Button>
				</Form>
			</FormContainer>
		</>
	);
};

export default Cadastro;