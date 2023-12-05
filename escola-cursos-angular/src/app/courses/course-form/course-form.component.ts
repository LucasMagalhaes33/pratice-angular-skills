import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {CoursesService} from "../services/courses.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent {

  form: FormGroup;
  constructor(private formsBuilder: FormBuilder,
              private service: CoursesService,
              private snackBar: MatSnackBar) {
    this.form = this.formsBuilder.group({
      name: [null],
      category: [null]
    })
  }

  protected readonly onsubmit = onsubmit;

  onCancel() {

  }

  onSubmit() {
    this.service.save(this.form.value)
      .subscribe(data => console.log(data),
        error => this.onError());
  }

  private onError(){
    this.snackBar.open('Erro ao salvar curso!',
      '', {duration: 5000})
  }
}
