import { useEffect, useState } from 'react';
import { Container, Table } from '@mui/material';
import DeleteForeverIcon from '@mui/icons-material/DeleteForever';
import EditIcon from '@mui/icons-material/Edit';
import VisibilityIcon from '@mui/icons-material/Visibility';
import '../../index.css';

export default function ListarEstudantes() {
    const[name,setName]=useState('')
    const[address,setAddress]=useState('')
    const[students,setStudents]=useState([])
    

useEffect(()=>{
    const student={name,address}
    console.log(student)
  fetch("http://localhost:8080/student/getAll")
  .then(res=>res.json())
  .then((result)=>{
    setStudents(result);
  }
)
},[])
  return (
  <Container>
    <h3 className='title'> Lista de Estudantes </h3>


    <div>
        <Table aria-label="sticky table">
            <tr>
                <td>ID</td>
                <td>NOME</td>
                <td>ENDEREÇO</td>
            </tr>
        {students.map(student=>(
            <tr>
                <td>{student.id} </td>
                <td>{student.name}<br/></td>
                <td>{student.address}</td>
                <td><VisibilityIcon/></td>
                <td><EditIcon/></td>
                <td><DeleteForeverIcon /></td>
            </tr>

        ))
        }

        </Table>
    </div>

  </Container>
);
}