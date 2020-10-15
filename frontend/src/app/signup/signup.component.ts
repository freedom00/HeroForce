import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidatorFn, Validators} from '@angular/forms';
import {SignupService} from '../service/signup.service';
import {Person} from '../entity/person';
import {Router} from '@angular/router';

function validator(nameRe: RegExp): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } | null => {
    const isValid = nameRe.test(control.value);
    return isValid ? null : {content: {value: control.value}};
  };
}

function compareDate(): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } | null => {
    const isValid = new Date(control.value) > new Date();
    return isValid ? {content: {value: control.value}} : null;
  };
}

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  formGroup: FormGroup;
  private PHONE_NUMBER_REG: RegExp = new RegExp('^\\d{3} ?\\d{3} ?\\d{4}$', 'i');
  private EMAIL_REG: RegExp = new RegExp('\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}', 'i');

  constructor(private signupService: SignupService, private router: Router) {
  }

  ngOnInit(): void {
    this.formGroup = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      birthday: new FormControl('', [Validators.required, compareDate()]),
      phoneNumber: new FormControl('', [Validators.required, validator(this.PHONE_NUMBER_REG)]),
      email: new FormControl('', [Validators.required, validator(this.EMAIL_REG)]),
      isMessageOnBirthday: new FormControl(true),
    });
  }

  onSubmit(): void {
    const person = new Person();
    person.FirstName = this.formGroup.get('firstName').value;
    person.LastName = this.formGroup.get('lastName').value;
    person.Birthday = this.formGroup.get('birthday').value;
    person.PhoneNumber = this.formGroup.get('phoneNumber').value.replace(/\s/g, '');
    person.Email = this.formGroup.get('email').value;
    person.IsMessageOnBirthday = this.formGroup.get('isMessageOnBirthday').value;
    this.signupService.submit(person).subscribe(result => {
      console.log(result);
      if (result) {
        this.router.navigate(['/home']);
      } else {
        console.log('submit error');
      }
    });
  }
}
