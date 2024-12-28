import axios from 'axios'

const EMPLOYEE_SERVICE_BASE_URL = "http://localhost:9191/api/employees/get";

const EMPLOYEE_ID = 1;

class EmployeeService{

    getEmployee(){
        return axios.get(EMPLOYEE_SERVICE_BASE_URL + '/' + EMPLOYEE_ID);
    }

}

const employee = new EmployeeService()

export default employee