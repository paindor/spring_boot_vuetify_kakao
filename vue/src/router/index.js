import Vue from 'vue'
import Router from 'vue-router'
import ArticleAdd from '@/components/article/ArticleAdd'
import ArticleEdit from '@/components/article/ArticleEdit'
import ArticleFindOne from '@/components/article/ArticleFindOne'
import ArticlesFindSome from '@/components/article/ArticlesFindSome'
import ArticleRemoval from '@/components/article/ArticleRemoval'
import Articles from '@/components/article/Articles'
import StudentAdd from '@/components/student/StudentAdd'
import StudentEdit from '@/components/student/StudentEdit'
import StudentFindOne from '@/components/student/StudentFindOne'
import StudentsFindSome from '@/components/student/StudentsFindSome'
import StudentRemoval from '@/components/student/StudentRemoval'
import Students from '@/components/student/Students'
import Join from '@/components/auth/Join'
import Login from '@/components/auth/Login'
import MyPage from '@/components/auth/MyPage'
import MyPageUpdate from '@/components/auth/MyPageUpdate'
import Admin from '@/components/admin/Admin'
import MyKakaoLogin from '@/components/auth/MyKakaoLogin'

Vue.use(Router)

export default new Router({
	mode: 'history',
	routes : [
		{path: '/articleAdd',name: 'articleAdd', component: ArticleAdd},
		{path: '/articleEdit',name: 'articleEdit', component: ArticleEdit},
		{path: '/articleRemoval',name: 'articleRemoval', component: ArticleRemoval},
		{path: '/articleFindOne',name: 'articleFindOne', component: ArticleFindOne},
		{path: '/articles',name: 'articles', component: Articles},
		{path: '/articlesFindSome',name: 'articlesFindSome', component: ArticlesFindSome},
		{path: '/studentAdd',name: 'studentAdd', component: StudentAdd},
		{path: '/studentEdit',name: 'studentEdit', component: StudentEdit},
		{path: '/studentFindOne',name: 'studentFindOne', component: StudentFindOne},
		{path: '/studentRemoval',name: 'studentRemoval', component: StudentRemoval},
		{path: '/students',name: 'students', component: Students},
		{path: '/studentsFindSome',name: 'studentsFindSome', component: StudentsFindSome},
		{path: '/join',name: 'join', component: Join},
		{path: '/login',name: 'login', component: Login},
		{path: '/myPage',name: 'myPage', component: MyPage},
		{path: '/myPageUpdate',name: 'myPageUpdate', component: MyPageUpdate},
		{path: '/admin',name: 'admin', component: Admin},
		{path: '/myKakaoLogin',name: 'myKakaoLogin', component: MyKakaoLogin},
	]
})