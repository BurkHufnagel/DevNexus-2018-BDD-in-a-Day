import { Component } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';
import {HttpParams} from '@angular/common/http';
import * as _ from 'lodash';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'BDD in a Day: Echo';
  initialSound = '';
  echoedSound = '';
  showContent=false;

  constructor(private http: HttpClient) {
  }

  private makeEcho(): void {
    this.echoedSound = 'Quiet, please...';
    const params = new HttpParams().set('sound', this.initialSound);
    this.http.get('/api/echo', {params, responseType: 'text'})
        .subscribe(response => this.echoedSound = response);
    this.showContent=true;
  }
}
