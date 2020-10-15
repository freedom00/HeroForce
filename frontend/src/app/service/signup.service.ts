import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ConfigService} from '../config/config.service';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private httpClient: HttpClient, private configService: ConfigService) {
  }

  submit(person: any): Observable<boolean> {
    const url = this.configService.configModel.apiServer.create;
    return this.httpClient.post<boolean>(url, person);
  }
}
