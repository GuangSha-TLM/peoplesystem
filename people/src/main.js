import Vue from 'vue'
import App from './App.vue'

import router from './router'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import 'lib-flexible/flexible.js'
Vue.config.productionTip = false

Vue.use(ElementUI);
Vue.prototype.$isMobile = /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
