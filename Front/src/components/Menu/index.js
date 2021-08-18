import { Link } from "react-router-dom"



export const Menu = () => {
    return (
        <nav style={{
            width: '100%',
            display: 'flex',
            justifyContent: 'space-around'
        }}>
            <Link to='/'>Home</Link>
            <Link to='/login'>Login</Link>
            <Link to='/cadastro'>Cadastro</Link>
        </nav>
    )
}