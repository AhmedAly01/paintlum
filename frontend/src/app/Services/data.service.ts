import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  Shape = new BehaviorSubject('');
  Shape$ = this.Shape.asObservable();
  delete = new BehaviorSubject('-1');
  delete$ = this.delete.asObservable();
  value = new BehaviorSubject('brush');
  value$ = this.value.asObservable();
  strokeColor = new BehaviorSubject('#000000');
  strokeColor$ = this.strokeColor.asObservable();
  fillColor = new BehaviorSubject('transparent');
  fillColor$ = this.fillColor.asObservable();
  strokeWidth = new BehaviorSubject("5");
  strokeWidth$ = this.strokeWidth.asObservable();

  constructor() {}

  getValue():Observable<string> {
    return this.value$;
  }

  setValue(val : string) {
    this.value.next(val);
  }

  getShape():Observable<string> {
    return this.Shape$;
  }

  setShape(und : string) {
    this.Shape.next(und);
  }

  getDelete():Observable<string> {
    return this.delete$;
  }

  setDelete(del : string) {
    this.delete.next(del);
  }

  getStrokeColor():Observable<string> {
    return this.strokeColor$;
  }

  setStrokeColor(sCl : string) {
    this.strokeColor.next(sCl);
  }

  getFillColor():Observable<string> {
    return this.fillColor$;
  }

  setFillColor(fCl : string) {
    this.fillColor.next(fCl);
  }

  getStrokeWidth(): Observable<string>{
      return this.strokeWidth$;
  }

  setsetstrokeWidth(stW : string) {
      this.strokeWidth.next(stW);
  }
}
