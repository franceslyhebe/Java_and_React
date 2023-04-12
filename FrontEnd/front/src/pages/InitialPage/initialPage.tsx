import { Typography } from "@mui/material"
import NavBar from "../../components/NavBar/navbar"
import Student from "../../components/Student/student"
import ListarEstudantes from "../../components/Student/listarEstudantes"

function InitialPage() {

    return (

        <>
        <NavBar></NavBar>
        <Typography component="h1" variant="h5">
        <Student/>
        <ListarEstudantes/>
      </Typography>
      </>
    )
  }
  
  export default InitialPage
  