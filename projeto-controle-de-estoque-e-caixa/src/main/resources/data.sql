-- Inserir Macarrão
INSERT INTO produto (nome, descricao, preco_venda, preco_compra, quantidade_estoque)
SELECT 'Macarrão', 'Macarrão integral', 2.60, 1.80, 100
    WHERE NOT EXISTS (SELECT 1 FROM produto WHERE nome = 'Macarrão');

-- Inserir Arroz
INSERT INTO produto (nome, descricao, preco_venda, preco_compra, quantidade_estoque)
SELECT 'Arroz', 'Arroz parboilizado', 3.50, 2.00, 150
    WHERE NOT EXISTS (SELECT 1 FROM produto WHERE nome = 'Arroz');

-- Inserir Feijão
INSERT INTO produto (nome, descricao, preco_venda, preco_compra, quantidade_estoque)
SELECT 'Feijão', 'Feijão carioca', 5.00, 3.00, 120
    WHERE NOT EXISTS (SELECT 1 FROM produto WHERE nome = 'Feijão');

-- Inserir Batata
INSERT INTO produto (nome, descricao, preco_venda, preco_compra, quantidade_estoque)
SELECT 'Batata', 'Batata inglesa', 1.80, 1.00, 200
    WHERE NOT EXISTS (SELECT 1 FROM produto WHERE nome = 'Batata');

-- Inserir Cenoura
INSERT INTO produto (nome, descricao, preco_venda, preco_compra, quantidade_estoque)
SELECT 'Cenoura', 'Cenoura orgânica', 1.50, 0.80, 180
    WHERE NOT EXISTS (SELECT 1 FROM produto WHERE nome = 'Cenoura');

-- Inserir Tomate
INSERT INTO produto (nome, descricao, preco_venda, preco_compra, quantidade_estoque)
SELECT 'Tomate', 'Tomate italiano', 2.20, 1.20, 130
    WHERE NOT EXISTS (SELECT 1 FROM produto WHERE nome = 'Tomate');

-- Inserir Frango
INSERT INTO produto (nome, descricao, preco_venda, preco_compra, quantidade_estoque)
SELECT 'Frango', 'Peito de frango', 7.50, 5.00, 80
    WHERE NOT EXISTS (SELECT 1 FROM produto WHERE nome = 'Frango');

-- Inserir Leite
INSERT INTO produto (nome, descricao, preco_venda, preco_compra, quantidade_estoque)
SELECT 'Leite', 'Leite integral', 2.80, 1.50, 110
    WHERE NOT EXISTS (SELECT 1 FROM produto WHERE nome = 'Leite');

-- Inserir Pão
INSERT INTO produto (nome, descricao, preco_venda, preco_compra, quantidade_estoque)
SELECT 'Pão', 'Pão integral', 2.00, 1.00, 140
    WHERE NOT EXISTS (SELECT 1 FROM produto WHERE nome = 'Pão');

-- Inserir Abacaxi
INSERT INTO produto (nome, descricao, preco_venda, preco_compra, quantidade_estoque)
SELECT 'Abacaxi', 'Abacaxi pérola', 3.75, 2.00, 70
    WHERE NOT EXISTS (SELECT 1 FROM produto WHERE nome = 'Abacaxi');

-- Inserir Queijo
INSERT INTO produto (nome, descricao, preco_venda, preco_compra, quantidade_estoque)
SELECT 'Queijo', 'Queijo muçarela', 4.75, 2.50, 90
    WHERE NOT EXISTS (SELECT 1 FROM produto WHERE nome = 'Queijo');

-- Inserir Ovos
INSERT INTO produto (nome, descricao, preco_venda, preco_compra, quantidade_estoque)
SELECT 'Ovos', 'Ovos orgânicos', 3.25, 1.50, 60
    WHERE NOT EXISTS (SELECT 1 FROM produto WHERE nome = 'Ovos');

-- Inserir Maçã
INSERT INTO produto (nome, descricao, preco_venda, preco_compra, quantidade_estoque)
SELECT 'Maçã', 'Maçã gala', 2.30, 1.20, 100
    WHERE NOT EXISTS (SELECT 1 FROM produto WHERE nome = 'Maçã');

