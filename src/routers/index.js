import { createRouter, createWebHistory } from "vue-router";
const createPath = (path, name, component, options = {}) => ({
  path,
  name,
  component,
  ...options,
});
const router = createRouter({
  history: createWebHistory(),
  routes: [
    createPath("/", "index", () => import("../pages/MainPage.vue")),
    createPath("/login", "login", () => import("../pages/Login.vue")),
    createPath("/manager_account", "manager_account", () => import("../pages/AcountManager.vue")),
    createPath("/manager_database", "manager_database", () => import("../pages/DatabaseManager.vue")),
    createPath("/manager_rule", "manager_rule", () => import("../pages/RuleManager.vue")),
    createPath("/manager_project", "manager_project", () => import("../pages/ProjectManager.vue")),
    createPath("/manager_system", "manager_system", () => import("../pages/SystemManager.vue")),
    createPath("/report", "report", () => import("../pages/Report.vue")),
    createPath("/redirect/:path(.*)*", "redirect", null),
    createPath("/:pathMatch(.*)*", "404", () =>
      import("../pages/Notfound.vue"),
    ),
  ],
});

export default router;
