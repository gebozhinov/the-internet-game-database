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
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 2);

INSERT INTO games(id, rating, release_date, manufacture_id, description, title, img_url)
SELECT 1, 9.5, TO_DATE('2010-11-02', 'YYYY-MM-DD'), 1, 'Good game!', 'GTA5', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700589423/igdb/vqifsqhvwsfgwygpoup9.jpg'
WHERE NOT EXISTS(SELECT id FROM games WHERE id = 1)
UNION ALL
SELECT 2, 8.8, TO_DATE('2023-10-01', 'YYYY-MM-DD'), 2, 'The incredible power of the symbiote forces Peter and Miles to face the ultimate test of strength,' ||
                                      ' both inside and outside the mask, as they balance their lives, friendships and their duty to protect those in need.',
    'Marvel''s Spider-Man 2', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700589961/igdb/k6pvdt0oq3lreqvsuqya.jpg'
WHERE NOT EXISTS(SELECT id FROM games WHERE id = 2);


INSERT INTO users_favorite_games(user_id, game_id)
SELECT 1, 1
WHERE NOT EXISTS(SELECT user_id FROM users_favorite_games WHERE user_id = 1)
UNION ALL
SELECT 1, 2
WHERE NOT EXISTS(SELECT user_id FROM users_favorite_games WHERE user_id = 1);


INSERT INTO game_genre(game_id, genre)
SELECT 1, 'SHOOTER'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 1)
UNION ALL
SELECT 1, 'RPG'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 1)
UNION ALL
SELECT 2, 'ADVENTURE'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 2);


INSERT INTO platforms(id, name, platform_family, platform_type)
VALUES (1, 'Playstation 5', 'PLAYSTATION', 'CONSOLE'),
       (2, 'XBOX ONE', 'XBOX', 'CONSOLE')
ON CONFLICT (name) DO NOTHING;

INSERT INTO games_platforms(game_id, platform_id)
SELECT 1, 1
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 1)
UNION ALL
SELECT 1, 2
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 1)
UNION ALL
SELECT 2, 1
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 2)
UNION ALL
SELECT 2, 2
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 2);



INSERT INTO reviews(id, created, review, author_id, game_id)
SELECT 1, TO_DATE('2023-11-02', 'YYYY-MM-DD'), 'It is great game!', 1, 1
WHERE NOT EXISTS (SELECT author_id FROM reviews WHERE author_id = 1)
UNION ALL
SELECT 2, TO_DATE('2023-11-02', 'YYYY-MM-DD'), 'You can play it all day long!', 1, 1
WHERE NOT EXISTS (SELECT author_id FROM reviews WHERE author_id = 1);