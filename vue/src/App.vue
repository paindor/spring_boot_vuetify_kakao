<template>
	<div id="app">
		<layout>
			<template #header="header">
				<h1>{{header.title}}</h1>
				<component :is="!loginCheck ? 'pre-auth' : 'post-auth'"></component>
			</template>
			<template #sidebar="sidebar">
				<!-- <component :is="sidebarCheck"></component> -->
				<ul v-if="loginCheck" class="menu" >
					<li v-for="sidebar of sidebarCheck" :key="sidebar.menu">
						<router-link :to='sidebar.link'>{{sidebar.menu}}</router-link>
					</li>
				</ul>
					
			</template>
			<template #content="content"><router-view/></template>
			<template #footer="footer">{{footer.title}}</template>
		</layout>
	</div>
</template>
<script>
import Layout from "@/components/cmm/Layout.vue"
import PostAuth from "@/components/cmm/PostAuth.vue"
import PreAuth from "@/components/cmm/PreAuth.vue"
import ManagerSidebar from "@/components/cmm/ManagerSidebar.vue"
import PreSidebar from "@/components/cmm/PreSidebar.vue"
import StudentSidebar from "@/components/cmm/StudentSidebar.vue"
 
export default{
	components : {Layout, PreAuth, PostAuth,
	ManagerSidebar, PreSidebar, StudentSidebar
	},
	computed:{
		
		loginCheck: function(){
			return this.$store.state.admin.isAuth
		},
		sidebarCheck: function(){
			return this.$store.state.admin.sidebars
		}
		
	}
}
</script>
<style scoped>
ul.menu {
    position:relative;
    padding: 5px 5px 5px 5px;
    list-style: none;
    font-style: italic;
}
ul.menu a {
    text-decoration:none;
}
</style>