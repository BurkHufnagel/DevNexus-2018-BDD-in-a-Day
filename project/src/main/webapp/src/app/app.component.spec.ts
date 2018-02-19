import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [FormsModule,
        HttpClientModule],
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  }));


  it('should create the application', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const application = fixture.debugElement.componentInstance;
    expect(application).toBeTruthy();
  }));


  it('should have "BDD in a Day: Echo" as the title ', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const application = fixture.debugElement.componentInstance;
    expect(application.title).toEqual('BDD in a Day: Echo');
  }));


  it('should render the title in an h1 tag', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('BDD in a Day: Echo');
  }));
});
