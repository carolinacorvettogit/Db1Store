import logo from './logo.svg';
import './App.css';

function App() {
  return (
  
<html lang="pt" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>E-commerce</title>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<link rel="icon" href="/image/favicon.png" />


	<link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="/webjars/open-iconic/font/css/open-iconic-bootstrap.min.css" rel="stylesheet" />
	
	
	<link href="/css/style.css" rel="stylesheet" />
</head>
<body>
	<header>
		<nav class="navbar navbar-inverse navbar navbar-dark bg-dark fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="btn btn-dark navbar-toggle pull-left">
						<i class="oi oi-menu"></i>
					</button>
					<a class="navbar-brand " href="#">Painel Administrativo E-commerce</a>
				</div>
			</div>
		</nav>
	</header>
	
	<div class="layout-main">	
	
		<aside>
			<nav class="sidebar sidebar-open">
				<ul class="nav nav-pills">
					<li class="nav-item"><a class="nav-link " href="/"> <i
							class="oi oi-home"></i> <span>Home</span>
					</a></li>
				</ul>

				<ul class="nav nav-pills">
					<li class="nav-item"><span class="nav-link active">Produtos</span></li>
					<li class="nav-item"><a class="nav-link" 
						href="adm/produto/cadastrar"> <i class="oi oi-plus"></i> <span>Cadastrar </span>
					</a></li>
					<li class="nav-item"><a class="nav-link" 
						href="adm/produto/listar"> <i class="oi oi-spreadsheet"></i> <span>Listar </span>
					</a></li>
				</ul>
			</nav>
		</aside>
			
	<section class="layout-content">
	
		<nav class="navbar navbar-expand-md bg-light">
			<div class="collapse navbar-collapse" id="navbarsExampleDefault">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<i class="oi oi-caret-right"></i>
						<span>Home</span>
					</li>
				</ul>
			</div>
		</nav>
		
		<div class="container">
			<div id="list-home" class="row">
				<div class="col-4">
					<div class="list-group" id="list-tab" role="tablist">
						<a class="list-group-item list-group-item-action active"
							id="list-produtos-list" data-toggle="list" href="#produtos"
							role="tab" aria-controls="produtos">Produtos</a> <a
							class="list-group-item list-group-item-action" id="list-carinho-list"
							data-toggle="list" href="#carinho" role="tab" aria-controls="carinho">Carrinho</a> 
							
					</div>
				</div>
				<div class="col-8">
					<div class="tab-content" id="nav-tabContent">
						<div class="tab-pane fade show active" id="produtos"
							role="tabpanel" aria-labelledby="list-produtos-list">
							<p>Produtos</p>
							<p>- Produto deve ter nome, preço, quantidade e foto(s)</p>
							<p>-  O usuário poderá editá-los ou exclui-los</p>
							<p>- Uma listagem mostrando os produtos cadastrados</p>
						</div>
						<div class="tab-pane fade" id="carinho" role="tabpanel"
							aria-labelledby="list-carinho-list">
							<p>Carrinho</p>
							<p>- Usuário deve ser capaz de adicionar e remover produtos</p>
							<p>- O usuário deve ser capaz de modificar a quantidade de itens</p>
							<p>- Deve ser calculado o valor total dos produtos do carrinho, atualizando-a
de acordo com a quantidade que o usuário informar</p>
							<p>- O botão “Finalizar” deve concluir a compra e levar a uma tela com a
compra finalizada, persistindo os dados no banco.</p>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		
	</section>		
	
	</div>
		
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/jquery-mask-plugin/dist/jquery.mask.min.js"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	    
		

	</script>
</body>
</html>

  );
}

export default App;
