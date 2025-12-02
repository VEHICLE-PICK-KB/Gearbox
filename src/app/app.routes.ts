import { Routes } from '@angular/router';
import { GearboxComponent } from './components/gearbox/gearbox.component';


export const routes: Routes = [
    {path: 'gearboxes', component: GearboxComponent},
    {path: ' ', redirectTo: 'gearboxes', pathMatch: 'full'}

];

