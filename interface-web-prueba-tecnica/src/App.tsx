import { useEffect, useState } from 'react'
import './App.css'

interface IExamenes{
  codigoExamen: string,
  resultado: number
}

interface IOrdenPaciente {
  _id: string,
  nombre: string,
  apellido: string,
  codigoOrden: string,
  examenes: IExamenes[]
}

const FetchData = async() => {
  const response = await fetch('http://localhost:8080/orden-paciente/', {
    method: "GET",
    headers: {
      "Content-Type": 'application/json'
    }
  })

  return await response.json()
}

function App() {
  const [data, setData] = useState<IOrdenPaciente[]>([])
  useEffect(() => {
    const fetchData = async () => {
      const resultado = await FetchData()
      setData(resultado)
    }
    fetchData() 
  }, [])
  return (
    <>
      <div>
        <table>
          <thead>
            <tr>
              <th>Nombre</th>
              <th>Codigo de Orden</th>
              <th>Resultado de Examenes</th>
            </tr>
          </thead>
          <tbody>
            {
              data?.map(({nombre, apellido, codigoOrden, examenes}, index) => (
                <tr key={index}>
                  <td>{nombre} {apellido}</td>
                  <td>{codigoOrden}</td>
                  <td>
                    <ul>
                      {
                        examenes?.map(({codigoExamen, resultado}, index) => (
                          <li key={index}>{codigoExamen} : {resultado}</li>
                        ))  
                      }
                    </ul>
                  </td>
                </tr>
              ))
            }
          </tbody>
        </table>
      </div>
    </>
  )
}

export default App
