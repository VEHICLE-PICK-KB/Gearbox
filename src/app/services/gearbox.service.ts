import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Gearbox } from '../models/gearbox';

@Injectable({
  providedIn: 'root'
})
export class GearboxService {

  private apiUrl = 'http://localhost:8080/api/gearboxes';

  constructor(private http: HttpClient) {}

  getAllGearboxes(): Observable<any[]>{
    return this.http.get<any[]>(this.apiUrl)
  }

  getGearbox(id: number): Observable<Gearbox> {
    return this.http.get<Gearbox>(`${this.apiUrl}/${id}`);
  }

  createGearbox(gearbox: Gearbox): Observable<Gearbox>{
    return this.http.post<Gearbox>(this.apiUrl, gearbox);
  }

  updateGearbox(id: number, gearbox: Gearbox): Observable<Gearbox>{
    return this.http.put<Gearbox>(`${this.apiUrl}/${id}`, gearbox);
  }

  deleteGearbox(id: number): Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/${id}`)
  }
   
}
