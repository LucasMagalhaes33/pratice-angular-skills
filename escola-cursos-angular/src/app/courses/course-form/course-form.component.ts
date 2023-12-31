import {Component} from '@angular/core';
import {NonNullableFormBuilder} from "@angular/forms";
import {CoursesService} from "../services/courses.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Location} from "@angular/common";

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent {

  form = this.formsBuilder.group({
    name: [''],
    category: ['']
  })
  constructor(private formsBuilder: NonNullableFormBuilder,
              private service: CoursesService,
              private snackBar: MatSnackBar,
              private location: Location) {

  }

  protected readonly onsubmit = onsubmit;

  onCancel() {
    this.location.back();
  }

  onSubmit() {
    this.service.save(this.form.value)
      .subscribe(data => this.onSuccess(),
        error => this.onError());
    this.onCancel();
  }

  private onError(){
    this.snackBar.open('Erro ao salvar curso!',
      '', {duration: 5000});
  }

  private onSuccess(){
    this.snackBar.open('Curso salvo com sucesso!',
      '', {duration: 5000})
  }

}
