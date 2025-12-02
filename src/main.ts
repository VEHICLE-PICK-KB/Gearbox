import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { GearboxComponent } from './app/components/gearbox/gearbox.component';

bootstrapApplication(GearboxComponent, appConfig)
  .catch((err) => console.error(err));
