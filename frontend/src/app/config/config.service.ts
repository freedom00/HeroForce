import {APP_INITIALIZER, Injectable} from '@angular/core';
import {IConfigModel} from './config.model';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})

export class ConfigService {
  configModel: IConfigModel;

  constructor(private httpClient: HttpClient) {
  }

  load(): Promise<void> {
    const jsonFile = `assets/config/config.${environment.name}.json`;
    return new Promise<void>((resolve, reject) => {
      this.httpClient.get(jsonFile).toPromise().then((response: IConfigModel) => {
        this.configModel = (response as IConfigModel);
        resolve();
      }).catch((response: any) => {
        reject(`Could not load file '${jsonFile}': ${JSON.stringify(response)}`);
      });
    });
  }
}

export function ConfigFactory(configService: ConfigService): any {
  return () => configService.load();
}

export function init(): any {
  return {
    provide: APP_INITIALIZER,
    useFactory: ConfigFactory,
    deps: [ConfigService],
    multi: true
  };
}

const ConfigModule = {
  init
};

export {ConfigModule};
