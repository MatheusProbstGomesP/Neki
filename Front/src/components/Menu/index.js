import { Link } from "react-router-dom"



export const Menu = () => {
    return (
        <nav style={{
            width: '100%',
            display: 'flex',
            justifyContent: 'space-around',
            backgroundColor: 'black',
            textDecoration: 'none',
            fontSize: 25,
        }}>
            <Link to='/login'>Login</Link>
            <Link to='/'>Home</Link>
            <Link to='/skill'>Skill</Link>
            <Link to='/user'>Usuario</Link>
            <Link to='/cadastro'>Cadastro</Link>
        </nav>
    )
}