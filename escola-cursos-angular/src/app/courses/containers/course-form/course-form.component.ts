import {Component} from '@angular/core';
import {FormGroup, NonNullableFormBuilder, UntypedFormArray, Validators} from "@angular/forms";
import {CoursesService} from "../../services/courses.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Location} from "@angular/common";
import {ActivatedRoute} from "@angular/router";
import {Course} from "../../model/course";
import {Lesson} from "../../model/lesson";

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent {

  form!: FormGroup;
  constructor(private formsBuilder: NonNullableFormBuilder,
              private service: CoursesService,
              private snackBar: MatSnackBar,
              private location: Location,
              private route: ActivatedRoute) {
    const course: Course = this.route.snapshot.data['course'];
    this.form = this.formsBuilder.group({
      _id:[course._id],
      name: [course.name, [Validators.required,
        Validators.minLength(5),
        Validators.maxLength(100)]],
      category: [course.category, [Validators.required]],
      lessons: this.formsBuilder.array(this.retrieveLessons(course))
    });

  }

  private retrieveLessons(course: Course) {
    const lessons = [];
    if (course?.lessons) {
      course.lessons.forEach(lesson => {
        lessons.push(this.createLesson(lesson));
      });
    } else {
      lessons.push(this.createLesson());
    }
    return lessons;
  }

  protected readonly onsubmit = onsubmit;

  private createLesson(lesson: Lesson = {id: '', name: '', youtubeUrl: ''}) {
    return this.formsBuilder.group({
      id: [lesson.id],
      name: [lesson.name, [Validators.required]],
      youtubeUrl: [lesson.youtubeUrl, [Validators.required]]
    });
  }

  getLessonsFormArray() {
    return (<UntypedFormArray>this.form.get('lessons')).controls;
  }

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

  protected readonly name = name;

  getErrorMessage(fieldName: string) {
    const field = this.form.get(fieldName);

    if (field?.hasError('required')) {
      return 'Campo obrigatório'
    }

    if (field?.hasError('minlength')) {
      const requiredLength = field?.errors ? field.errors['minlength']['requiredLength'] : 5;
      return `Tamanho mínimo precisa ser de  ${requiredLength} caracteres`;
    }

    if (field?.hasError('minlength')) {
      const requiredLength = field?.errors ? field.errors['maxlength']['requiredLength'] : 200;
      return `Tamanho máximo excedido de ${requiredLength} caracteres`;
    }

    return 'Campo inválido'
  }
}
