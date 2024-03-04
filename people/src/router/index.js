/$$
 $ @Author: tianleiyu 
 $ @Date: 2024-03-04 16:49:15
 $ @LastEditTime: 2024-03-04 19:21:52
 $ @LastEditors: tianleiyu
 $ @Description: 
 $ @FilePath: /people/src/router/index.js
 $ @可以输入预定的版权声明、个性签名、空行等
 $/
import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
