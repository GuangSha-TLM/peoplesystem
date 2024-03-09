
import { getToken } from '@/utils/token'
import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'login',
    component: () => import(/* webpackChunkName: "about" */ '../views/login.vue')
  },
  
  {
    path: '/register',
    name: 'register',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/register.vue')
  },
  {
    path: '/',
    name: 'home',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/home.vue'),
    meta: { requiresAuth: true }
  },
  {
    path: '/extract',
    name: 'extract',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/extract.vue'),
    meta: { requiresAuth: true }
  },
  {
    path:'/list',
    name: 'list',
    component:() => import(/* webpackChunkName: "about" */ '../components/List.vue'),
    meta: { requiresAuth: true }
},
]


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
router.beforeEach((to, from, next) => {
  // to:可以获得你想要跳转到那个路由的信息
  //from: 可以获取到你从那个路由来的
  // next :  放行函数 next() 放行 next(path) 放行到那个指定路由 
  let token = getToken()
  if (to.matched.some(record => record.meta.requiresAuth)) {
    // 需要身份验证的路由
    if (token) {
      next(); // 用户已登录，继续导航
    } else {
      next('/login'); // 用户未登录，重定向到登录页
    }
  } else {
    next(); // 不需要身份验证的路由，直接继续导航
  }

})
export default router
