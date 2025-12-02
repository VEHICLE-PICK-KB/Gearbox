import { Component, OnInit } from '@angular/core';
import { GearboxService } from '../../services/gearbox.service';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { Gearbox } from '../../models/gearbox';


@Component({
  selector: 'app-gearbox',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './gearbox.component.html',
  styleUrl: './gearbox.component.css'
})
export class GearboxComponent implements OnInit {
  gearboxes: any[] = [];

  currentGearbox: Gearbox = {
    model: '',
    type: '',
    gears: 1,
    manufacturer: '',
    manufyear: 1886

  }

  gearTypes: string[] = ["Automatic", "Manual", "Sequential", "CVT"];

  isEditing: boolean = false;
  

  constructor(private gearboxService: GearboxService){}

  ngOnInit(): void {

    this.loadGearboxes();}


    loadGearboxes(): void{this.gearboxService.getAllGearboxes().subscribe(data => {
      this.gearboxes = data;
    })
    
  }

  editGearbox(g: Gearbox): void {
    this.currentGearbox = {...g};
    this.isEditing = true;
  }

  deleteGearbox(id?: number): void{
    if (!id) return;
    if (!confirm('Are you sure you want to remove this entry?')) return;

    this.gearboxService.deleteGearbox(id).subscribe(() => {
      this.loadGearboxes();
      if (this.currentGearbox.id === id) {
        this.resetForm();
      }
    });
  }

saveGearbox(form: NgForm): void {
if (form.invalid) {
    return; 
  }

  if(this.isEditing && this.currentGearbox.id){
    this.gearboxService.updateGearbox(this.currentGearbox.id, this.currentGearbox).subscribe(() => {
      this.loadGearboxes();
      this.resetForm();
    });
  } else {
    this.gearboxService.createGearbox(this.currentGearbox).subscribe(() => {
      this.loadGearboxes();
      this.resetForm();
    });
  }
}
resetForm(): void {
  this.currentGearbox = {
    model: '',
    type: '',
    gears: 1,
    manufacturer: '',
    manufyear: 1886
  };
  this.isEditing = false;
}
}




