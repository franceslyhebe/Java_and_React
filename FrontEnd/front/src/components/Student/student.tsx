import { useState, useEffect } from 'react';
import { Container , Button, TextField, Box} from '@mui/material';
import '../../index.css';


export default function Student() {
    const[name,setName]=useState('')
    const[address,setAddress]=useState('')
    const[students,setStudents]=useState([])

  const handleClick=(e: any): void=>{
    e.preventDefault()
    const student={name,address}
    console.log(student)
    fetch("http://localhost:8080/student/add",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(student)

  }).then(()=>{
    console.log("New Student added")
  });

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
}
  return (

    <Container>
    <h3 className='title'> Adicionar Estudante </h3>

    <form noValidate autoComplete="off" className='FormCadastro'>
    
    <Box sx={{display: 'flex', flexDirection: 'column'}} >
  
      <TextField id="outlined-basic" label="Nome do Aluno" fullWidth variant="outlined" margin='normal'
      size="small"
      value={name}
      onChange={(e)=>setName(e.target.value)}
      />
      <TextField id="outlined-basic" label="Endereço do Aluno" fullWidth variant="outlined" margin='normal'
      size="small"
      value={address}
      onChange={(e)=>setAddress(e.target.value)}
      />

      <Button variant="contained" color="secondary" onClick={handleClick}>
        Submit
      </Button>

    </Box>
    </form>
    </Container>
  );
}
