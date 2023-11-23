INSERT INTO roles(user_role)
VALUES ('USER'),
       ('MODERATOR'),
       ('ADMIN')
ON CONFLICT (user_role) DO NOTHING;

INSERT INTO users(age, email, password, username)
VALUES (33, 'admin@admin.com', '$2a$10$6b.VoCrHD6ShKxGx8HDq8.ioLQ4h.op09vgCPfgHcqqLIeA2UY97e', 'admin')
ON CONFLICT (username) DO NOTHING;


INSERT INTO users_roles(user_id, role_id)
SELECT 1, 1
WHERE NOT EXISTS (SELECT user_id FROM users_roles WHERE user_id = 1)
UNION ALL
SELECT 1, 2
WHERE NOT EXISTS (SELECT user_id FROM users_roles WHERE user_id = 1)
UNION ALL
SELECT 1, 3
WHERE NOT EXISTS (SELECT user_id FROM users_roles WHERE user_id = 1);


INSERT INTO manufactures(id, company_name)
SELECT 1, 'Rockstar'
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 1)
UNION ALL
SELECT 2, 'Insomniac Games'
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 2)
UNION ALL
SELECT 3, 'Turn 10 Studios'
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 3)
UNION ALL
SELECT 4, 'Ubisoft Bordeaux'
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 4)
UNION ALL
SELECT 5, 'CD Projekt RED'
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 5);


INSERT INTO games(id, rating, release_date, manufacture_id, description, title, img_url)
SELECT 1, 9.5, TO_DATE('2010-11-02', 'YYYY-MM-DD'), 1, 'Good game!', 'GTA5', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700589423/igdb/vqifsqhvwsfgwygpoup9.jpg'
WHERE NOT EXISTS(SELECT id FROM games WHERE id = 1)
UNION ALL
SELECT 2, 8.8, TO_DATE('2023-10-10', 'YYYY-MM-DD'), 2, 'The incredible power of the symbiote forces Peter and Miles to face the ultimate test of strength,' ||
                                      ' both inside and outside the mask, as they balance their lives, friendships and their duty to protect those in need.',
    'Marvel''s Spider-Man 2', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700589961/igdb/k6pvdt0oq3lreqvsuqya.jpg'
WHERE NOT EXISTS(SELECT id FROM games WHERE id = 2)
UNION ALL
SELECT 3, 8.1, TO_DATE('2023-10-10', 'YYYY-MM-DD'), 3, 'Out-build the competition in the new career.' ||
                                                       ' Race your friends in adjudicated multiplayer events.' ||
                                                       ' Compete in over 500 cars on world-famous tracks with cutting-edge AI, ' ||
                                                       'advanced physics, tire and fuel strategy, and driver and safety ratings.',
    'Forza Motorsport', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700760616/igdb/zigu4fdswgdukfc7hcte.jpg'
WHERE NOT EXISTS(SELECT id FROM games WHERE id = 3)
UNION ALL
SELECT 4, 7.2, TO_DATE('2023-10-05', 'YYYY-MM-DD'), 4, 'In the ninth century CE, Baghdad is at its height, ' ||
                                                       'leading the world in science, art, innovation, and commerce.' ||
                                                       ' Amid its bustling urban landscape, a conflicted young orphan ' ||
                                                       'with a tragic past must navigate the streets to survive.',
    'Assassin''s Creed Mirage', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700760616/igdb/zwphvtir9hwmj5rnhxmi.jpg'

WHERE NOT EXISTS(SELECT id FROM games WHERE id = 4)
UNION ALL
SELECT 5, 9.0, TO_DATE('2023-09-26', 'YYYY-MM-DD'), 5, 'Phantom Liberty is a spy-thriller expansion for the open-world action-adventure RPG Cyberpunk 2077.' ||
                                                       ' When the orbital shuttle of the President of the New United States of America ' ||
                                                       'is shot down over the deadliest district of Night City, ' ||
                                                       'there’s only one person who can save her — you. Become V, a cyberpunk for hire,' ||
                                                       ' and dive deep into a tangled web of espionage and political intrigue, ' ||
                                                       'unraveling a story that connects the highest echelons of power with the brutal world of black-market mercenaries.',
    'Cyberpunk 2077: Phantom Liberty', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700760616/igdb/kykutv0pdu2xmjqglkam.jpg'
WHERE NOT EXISTS(SELECT id FROM games WHERE id = 5);


INSERT INTO users_favorite_games(user_id, game_id)
SELECT 1, 1
WHERE NOT EXISTS(SELECT user_id FROM users_favorite_games WHERE user_id = 1)
UNION ALL
SELECT 1, 2
WHERE NOT EXISTS(SELECT user_id FROM users_favorite_games WHERE user_id = 1)
UNION ALL
SELECT 1, 3
WHERE NOT EXISTS(SELECT user_id FROM users_favorite_games WHERE user_id = 1)
UNION ALL
SELECT 1, 4
WHERE NOT EXISTS(SELECT user_id FROM users_favorite_games WHERE user_id = 1)
UNION ALL
SELECT 1, 5
WHERE NOT EXISTS(SELECT user_id FROM users_favorite_games WHERE user_id = 1);


INSERT INTO game_genre(game_id, genre)
SELECT 1, 'SHOOTER'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 1)
UNION ALL
SELECT 1, 'RPG'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 1)
UNION ALL
SELECT 2, 'ADVENTURE'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 2)
UNION ALL
SELECT 3, 'RACING'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 3)
UNION ALL
SELECT 3, 'SPORT'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 3)
UNION ALL
SELECT 4, 'ADVENTURE'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 4)
UNION ALL
SELECT 5, 'ADVENTURE'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 5)
UNION ALL
SELECT 5, 'RPG'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 5)
UNION ALL
SELECT 5, 'SHOOTER'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 5);


INSERT INTO platforms(id, name, platform_family, platform_type)
VALUES (1, 'PC (Microsoft Windows)', 'PC', 'PC'),
       (2, 'Playstation 5', 'PLAYSTATION', 'CONSOLE'),
       (3, 'XBOX ONE', 'XBOX', 'CONSOLE'),
       (4, 'Playstation 4', 'PLAYSTATION', 'CONSOLE'),
       (5, 'Xbox Series X|S', 'XBOX', 'CONSOLE')
ON CONFLICT (name) DO NOTHING;

INSERT INTO games_platforms(game_id, platform_id)
SELECT 1, 2
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 1)
UNION ALL
SELECT 1, 3
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 1)
UNION ALL
SELECT 2, 2
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 2)
UNION ALL
SELECT 2, 3
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 2)
UNION ALL
SELECT 3, 1
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 3)
UNION ALL
SELECT 3, 3
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 3)
UNION ALL
SELECT 4, 1
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 4)
UNION ALL
SELECT 4, 2
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 4)
UNION ALL
SELECT 4, 3
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 4)
UNION ALL
SELECT 4, 4
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 4)
UNION ALL
SELECT 4, 5
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 4)
UNION ALL
SELECT 5, 1
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 5)
UNION ALL
SELECT 5, 2
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 5)
UNION ALL
SELECT 5, 5
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 5);


INSERT INTO reviews(id, created, review, author_id, game_id)
SELECT 1, TO_DATE('2023-11-02', 'YYYY-MM-DD'), 'It is great game!', 1, 1
WHERE NOT EXISTS (SELECT author_id FROM reviews WHERE author_id = 1)
UNION ALL
SELECT 2, TO_DATE('2023-11-02', 'YYYY-MM-DD'), 'You can play it all day long!', 1, 1
WHERE NOT EXISTS (SELECT author_id FROM reviews WHERE author_id = 1);