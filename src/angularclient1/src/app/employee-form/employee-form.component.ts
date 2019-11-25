import { Component } from '@angular/core';
import { Employee } from '../employee';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeServiceService } from '../employee-service.service';
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})
export class EmployeeFormComponent {


  employee: Employee;
  model: NgbDateStruct;
  date: {year: number, month: number};

  

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private employeeService: EmployeeServiceService,private calendar: NgbCalendar) {
    this.employee = new Employee();
  }

  onSubmit() {

    this.employeeService.save(this.employee).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/employee']);
  }


  

}
