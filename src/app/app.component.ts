import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GearboxComponent } from "./components/gearbox/gearbox.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, GearboxComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'gearbox-frontend';
}
