export class Person {
  private firstName: string;
  private lastName: string;
  private birthday: string;
  private phoneNumber: string;
  private email: string;
  private isMessageOnBirthday: boolean;

  get FirstName(): string {
    return this.firstName;
  }

  set FirstName(value: string) {
    this.firstName = value;
  }

  get LastName(): string {
    return this.lastName;
  }

  set LastName(value: string) {
    this.lastName = value;
  }

  get Birthday(): string {
    return this.birthday;
  }

  set Birthday(value: string) {
    this.birthday = value;
  }

  get PhoneNumber(): string {
    return this.phoneNumber;
  }

  set PhoneNumber(value: string) {
    this.phoneNumber = value;
  }

  get Email(): string {
    return this.email;
  }

  set Email(value: string) {
    this.email = value;
  }

  get IsMessageOnBirthday(): boolean {
    return this.isMessageOnBirthday;
  }

  set IsMessageOnBirthday(value: boolean) {
    this.isMessageOnBirthday = value;
  }
}
