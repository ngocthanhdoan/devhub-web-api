export default {
    install(app, options) {
      const languages = options.languages;
      const translate = (msgCode) => languages[msgCode] ?? msgCode;
      app.config.globalProperties.$translate = translate;
      app.provide("translate", translate);
    },
  };
  