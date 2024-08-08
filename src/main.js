import "./assets/css/style68b3.css";
import "./assets/css/style77ae.css";
import "./assets/css/style5152.css";
import "./assets/css/styled5f7.css";
import { createApp } from 'vue'
import Router from "./routers";
import Translator from "./plugins/translate.js";
import App from './App.vue'

const app = createApp(App);
import(
    `./assets/languages/${window.sessionStorage.langs ?? "vi_VN"}.json`
).then((languages) => {
    app
        .provide("instance", app)
        .use(Router)
        .use(Translator, { languages })
        .mount("#app")
});
