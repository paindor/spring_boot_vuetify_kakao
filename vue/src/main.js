import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import router from '@/router'
import vuex from 'vuex'
import {store} from '@/store'
//import VSwitch from 'v-switch-case'
import Axios from 'axios'

Vue.config.productionTip = false
Vue.prototype.$http = Axios
//Vue.use(VSwitch)

new Vue({
  vuetify,
  router,
  vuex,
  store,
  render: h => h(App)
}).$mount('#app')